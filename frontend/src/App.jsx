// import { useEffect, useState } from "react";
// import { api } from "./api";
// import AddSweet from "./components/AddSweet";
// import SweetTable from "./components/SweetTable";

// function App() {
//   const [sweets, setSweets] = useState([]);

//   const loadSweets = async () => {
//     const res = await api.get("/sweets");
//     setSweets(res.data);
//   };

//   useEffect(() => {
//     loadSweets();
//   }, []);

//   return (
//     <>
//       <h1>Sweet Shop Management</h1>
//       <AddSweet onAdd={loadSweets} />
//       <SweetTable sweets={sweets} onChange={loadSweets} />
//     </>
//   );
// }

// export default App;
import { useEffect, useState } from "react";
import { api } from "./api";
import AddSweet from "./components/AddSweet";
import SweetTable from "./components/SweetTable";
import "./App.css";

function App() {
  const [sweets, setSweets] = useState([]);

  const loadSweets = async () => {
    const res = await api.get("/sweets");
    setSweets(res.data);
  };

  useEffect(() => {
    loadSweets();
  }, []);

  return (
    <div className="app-container">
      <h1>🍬 Sweet Shop Management</h1>
      <AddSweet onAdd={loadSweets} />
      <SweetTable sweets={sweets} onChange={loadSweets} />
    </div>
  );
}

export default App;
