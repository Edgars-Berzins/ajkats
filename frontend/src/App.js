import './App.css';
import { Tasks } from './components/admin/Tasks';
import { Students } from './components/admin/Student';

function App() {
  return (
    <div className="flex items-center justify-center h-[99.9vh] w-full">
      <Students/>
    </div>
  );
}

export default App;
