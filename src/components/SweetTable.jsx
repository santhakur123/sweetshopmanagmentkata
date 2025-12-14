// import { api } from "../api";

// export default function SweetTable({ sweets, onChange }) {

//   const sellSweet = async (id) => {
//     await api.put(`/sweets/${id}/sell`);
//     onChange();
//   };

//   return (
//     <>
//       <h3>Available Sweets</h3>
//       <table border="1">
//         <thead>
//           <tr>
//             <th>Name</th>
//             <th>Price</th>
//             <th>Quantity</th>
//             <th>Sell</th>
//           </tr>
//         </thead>
//         <tbody>
//           {sweets.map(s => (
//             <tr key={s.id}>
//               <td>{s.name}</td>
//               <td>₹{s.price}</td>
//               <td>{s.quantity}</td>
//               <td>
//                 <button onClick={() => sellSweet(s.id)}>
//                   Sell 1
//                 </button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </>
//   );
// }
import { api } from "../api";

export default function SweetTable({ sweets, onChange }) {

  const sellSweet = async (id) => {
    await api.put(`/sweets/${id}/sell`);
    onChange();
  };

  const deleteSweet = async (id) => {
    await api.delete(`/sweets/${id}`);
    onChange();
  };

  return (
    <div className="card">
      <h3>Available Sweets</h3>

      <table className="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Price (₹)</th>
            <th>Quantity</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {sweets.map((s) => (
            <tr key={s.id}>
              <td  className="sweet-name">{s.name}</td>
              <td className="sweet-name">{s.price}</td>
              <td>
                <span className={`badge ${s.quantity > 2 ? "green" : "red"}`}>
                  {s.quantity}
                </span>
              </td>
              <td>
                <button className="sell" onClick={() => sellSweet(s.id)}>
                  Sell 1
                </button>
                <button className="delete" onClick={() => deleteSweet(s.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
