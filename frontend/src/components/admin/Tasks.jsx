import axios from "axios";
import React, { useEffect, useState } from "react";

export const Tasks = () => {
    const apiUrl = "http://localhost:8080/task";
    const [description, setDescription] = useState("");
    const [maxPoints, setMaxPoints] = useState(1);
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        try {
            const response = await axios.get(apiUrl + "/all");
            setTasks(response.data);
        } catch (error) {
            console.error("Error fetching tasks:", error);
        }
    };

    const createTask = async () => {
        const task = { taskDescription: description, maximumPoints: maxPoints };
        try {
            const response = await axios.post(apiUrl, task);
            setTasks([...tasks, response.data]);
        } catch (error) {
            console.error("Error creating task:", error);
        }
    };

    const deleteTask = async (id) => {
        try {
            await axios.delete(`${apiUrl}/${id}`); 
            setTasks(tasks.filter((task) => task.id !== id));
        } catch (error) {
            console.error("Error deleting task:", error);
        }
    };

    return (
        <div className="w-[50vw] h-[80vh] bg-white rounded-xl">
            <div className="bg-[#758AA2] p-5 flex gap-5 justify-center rounded-t-xl">
                <input
                    className="p-2 rounded-md w-full outline-none px-5 text-black"
                    placeholder="Description"
                    type="text"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                />
                <input
                    className="p-2 rounded-md w-full outline-none px-5 text-black"
                    placeholder="Max Points"
                    type="number"
                    min={1}
                    max={20}
                    value={maxPoints}
                    onChange={(e) => setMaxPoints(parseFloat(e.target.value))}
                />
                <button onClick={createTask} className="py-2 px-5 rounded-md bg-[#2B2B52]">
                    Add
                </button>
            </div>
            <h1 className="text-black text-center pt-10 font-bold">List Of Tasks</h1>
            <div className="p-5 space-y-2 overflow-y-auto h-[60vh]">
                {tasks.map((item, index) => (
                    <div className="bg-[#99AAAB] p-3 rounded-md flex items-center justify-between" key={item.id}>
                        <div className="">
                            <p className="text-gray-900 text-sm">
                                {index + 1}. 
                                Task: {item.taskDescription}.
                            </p>
                            <p className="text-gray-900 text-sm">
                                Max Points: {item.maximumPoints}.
                            </p>
                        </div>
                        <div className="flex space-x-4">
                            <button
                                onClick={() => deleteTask(item.id)}
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
        </div>
    );
};
