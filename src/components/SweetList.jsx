// import { useEffect, useState } from "react";
// import { api } from "../api";

// export default function SweetList() {
//   const [sweets, setSweets] = useState([]);

//   useEffect(() => {
//     api.get("/sweets").then(res => setSweets(res.data));
//   }, []);

//   return (
//     <ul>
//       {sweets.map(s => (
//         <li key={s.id}>{s.name} - ₹{s.price}</li>
//       ))}
//     </ul>
//   );
// }
export default function SweetList({ sweets }) {
  return (
    <ul>
      {sweets.map((s) => (
        <li key={s.id}>
          {s.name} - ₹{s.price} ({s.quantity})
        </li>
      ))}
    </ul>
  );
}
