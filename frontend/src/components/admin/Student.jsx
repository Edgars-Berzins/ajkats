import axios from "axios";
import React, { useEffect, useState } from "react";

export const Students = () => {
    const apiUrl = "http://localhost:8080/student";
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [matriculationNumber, setMatriculationNumber] = useState("");
    const [updateName, setUpdateName] = useState("");
    const [updateSurname, setUpdateSurname] = useState("");
    const [updateMatriculationNumber, setUpdateMatriculationNumber] = useState("");
    const [students, setStudents] = useState([]);
    const [selectedStudent, setSelectedStudent] = useState(null); // New state for selected student
    const [currentPage, setCurrentPage] = useState(0);
    const [totalStudents, setTotalStudents] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [displayedStudents, setDisplayedStudents] = useState([]); // State for displayed students
    const studentsPerPage = 8;

    const fetchTotalStudents = async () => {
        try {
            const response = await axios.get(`${apiUrl}/all`);
            setTotalStudents(response.data.length);
        } catch (error) {
            console.error("Error fetching total number of students:", error);
        }  
    };

    const fetchStudentsByPage = async (page) => {
        try {
            const response = await axios.get(`${apiUrl}/all/page?page=${page}&size=${studentsPerPage}`);
            setStudents(prevStudents => [...prevStudents, ...response.data]); // Append new data to the existing students array
        } catch (error) {
            console.error("Error fetching students:", error);
        }
    };
    
    
    useEffect(() => {
        fetchTotalStudents();
    }, []);
    
    useEffect(() => {
        fetchStudentsByPage(currentPage);
    }, [currentPage]); // Fetch students whenever currentPage changes
    
    useEffect(() => {
        const totalPages = Math.ceil(totalStudents / studentsPerPage) || 1;
        setTotalPages(totalPages);
    }, [totalStudents]);

    // Update displayedStudents whenever students or currentPage changes
    useEffect(() => {
        const startIndex = currentPage * studentsPerPage;
        const endIndex = Math.min(startIndex + studentsPerPage, totalStudents);
        const displayedStudents = students.slice(startIndex, endIndex);
        setDisplayedStudents(displayedStudents);
    }, [students, currentPage, totalStudents]);

    console.log(displayedStudents);

    const prevPage = () => {
        const newPage = Math.max(currentPage - 1, 0); // Ensure new page is within bounds
        setCurrentPage(newPage);
    };

    const nextPage = () => {
        const newPage = Math.min(currentPage + 1, totalPages - 1); // Ensure new page is within bounds
        setCurrentPage(newPage);
    };

    const renderPagination = () => {
        if (totalStudents === 0) {
            return null; // Don't render pagination if there are no students
        }

        return (
            <div className="flex justify-center space-x-4 mt-4">
                <button onClick={prevPage} disabled={currentPage === 0} className="px-3 py-1 bg-gray-300 rounded-md">Previous</button>
                <span>{currentPage + 1} / {totalPages}</span>
                <button onClick={nextPage} disabled={currentPage === totalPages - 1} className="px-3 py-1 bg-gray-300 rounded-md">Next</button>
            </div>
        );
    };


    const createStudent = async () => {
        const student = { name: name, surname: surname, matriculationNumber: matriculationNumber };
        try {
            const response = await axios.post(apiUrl, student);
            setStudents([...students, response.data]); // Update with the new list from the server
            setName("");
            setSurname("");
            setMatriculationNumber("");
        } catch (error) {
            console.error("Error creating student:", error);
        }
    };

    const deleteStudent = async (id) => {
        try {
            await axios.delete(`${apiUrl}/${id}`);
            setStudents(prevStudents => prevStudents.filter((student) => student.id !== id)); // Filter out the deleted student
        } catch (error) {
            console.error("Error deleting student:", error);
        }
    };

    const updateStudent = async () => {
        const updatedStudent = {
            id: selectedStudent.id,
            name: updateName,
            surname: updateSurname,
            matriculationNumber: updateMatriculationNumber
        };
        try {
            await axios.put(`${apiUrl}/${selectedStudent.id}`, updatedStudent);
            const updatedStudents = students.map(student =>
                student.id === selectedStudent.id ? updatedStudent : student
            );
            setStudents(updatedStudents);
            setSelectedStudent(null); // Clear selected student after update
            // Clear update fields after update
            setUpdateName("");
            setUpdateSurname("");
            setUpdateMatriculationNumber("");
        } catch (error) {
            console.error("Error updating student:", error);
        }
    };

    // Function to handle edit button click
    const handleEditClick = (student) => {
        setSelectedStudent(student);
        // Set input field values based on the selected student
        setUpdateName(student.name);
        setUpdateSurname(student.surname);
        setUpdateMatriculationNumber(student.matriculationNumber);
    };

    // Function to handle field change when editing
    const handleFieldChange = (e, fieldName) => {
        const value = e.target.value;
        switch (fieldName) {
            case "updateName":
                setUpdateName(value);
                break;
            case "updateSurname":
                setUpdateSurname(value);
                break;
            case "updateMatriculationNumber":
                setUpdateMatriculationNumber(value);
                break;
            default:
                break;
        }
    };

    return (
        <div className="w-[50vw] h-[80vh] bg-white rounded-xl">
            <div className="bg-[#758AA2] p-5 flex gap-5 justify-center rounded-t-xl">
                <input
                    className="p-2 rounded-md w-full outline-none px-5 text-black"
                    placeholder="Name"
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <input
                    className="p-2 rounded-md w-full outline-none px-5 text-black"
                    placeholder="Surname"
                    type="text"
                    value={surname}
                    onChange={(e) => setSurname(e.target.value)}
                />
                <input
                    className="p-2 rounded-md w-full outline-none px-5 text-black"
                    placeholder="Matricula number"
                    type="text"
                    value={matriculationNumber}
                    onChange={(e) => setMatriculationNumber(e.target.value)}
                />
                {selectedStudent ? (
                    <button onClick={updateStudent} className="py-2 px-5 rounded-md bg-[#2B2B52]">
                        Update
                    </button>
                ) : (
                    <button onClick={createStudent} className="py-2 px-5 rounded-md bg-[#2B2B52]">
                        Add
                    </button>
                )}
            </div>
            <h1 className="text-black text-center pt-10 font-bold">List Of Students</h1>
            <div className="p-5 space-y-2 overflow-y-auto h-[60vh]">
                {displayedStudents.map((student, index) => (
                    <div className="bg-[#99AAAB] p-3 rounded-md flex items-center justify-between" key={student.id}>
                        <div className="">
                            {selectedStudent && selectedStudent.id === student.id ? (
                                <>
                                    <input
                                        className="p-2 rounded-md outline-none px-5 text-black"
                                        type="text"
                                        value={updateName}
                                        onChange={(e) => handleFieldChange(e, "updateName")}
                                    />
                                    <input
                                        className="p-2 rounded-md outline-none px-5 text-black"
                                        type="text"
                                        value={updateSurname}
                                        onChange={(e) => handleFieldChange(e, "updateSurname")}
                                    />
                                    <input
                                        className="p-2 rounded-md outline-none px-5 text-black"
                                        type="text"
                                        value={updateMatriculationNumber}
                                        onChange={(e) => handleFieldChange(e, "updateMatriculationNumber")}
                                    />
                                </>
                            ) : (
                                <p className="text-gray-900 text-sm">
                                    {index + 1}. Name: {student.surname}, Surname: {student.name}, Matricula number: {student.matriculationNumber}
                                </p>
                            )}
                        </div>
                        <div className="flex space-x-4">
                            {selectedStudent && selectedStudent.id === student.id ? (
                                <button onClick={updateStudent} className="text-blue-600 hover:text-white focus:outline-none rounded-full hover:bg-blue-600 p-2" aria-label="Save">
                                    Save
                                </button>
                            ) : (
                                <button onClick={() => handleEditClick(student)} className="text-blue-600 hover:text-white focus:outline-none rounded-full hover:bg-blue-600 p-2" aria-label="Edit">
                                    Edit
                                </button>
                            )}
                            <button
                                onClick={() => deleteStudent(student.id)}
                                className="text-red-600 hover:text-white focus:outline-none rounded-full hover:bg-red-600 p-2"
                                aria-label="Delete"
                            >
                                <svg
                                    className="h-6 w-6"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                    stroke="currentColor"
                                >
                                    <path
                                        strokeLinecap="round"
                                        strokeLinejoin="round"
                                        strokeWidth="2"
                                        d="M6 18L18 6M6 6l12 12"
                                    ></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                ))}
            </div>
            {renderPagination()}
        </div>
    );
};
