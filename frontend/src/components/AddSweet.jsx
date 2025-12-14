// import { useState } from "react";
// import { api } from "../api";

// export default function AddSweet({ onAdd }) {
//   const [name, setName] = useState("");
//   const [price, setPrice] = useState("");
//   const [quantity, setQuantity] = useState("");

//   const submit = async () => {
//     await api.post("/sweets", {
//       name,
//       price,
//       quantity
//     });

//     setName("");
//     setPrice("");
//     setQuantity("");
//     onAdd();
//   };

//   return (
//     <>
//       <h3>Add Sweet</h3>
//       <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
//       <input placeholder="Price" value={price} onChange={e => setPrice(e.target.value)} />
//       <input placeholder="Quantity" value={quantity} onChange={e => setQuantity(e.target.value)} />
//       <button onClick={submit}>Add</button>
//     </>
//   );
// }
import { useState } from "react";
import { api } from "../api";

export default function AddSweet({ onAdd }) {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");

  const submit = async () => {
    if (!name || !price || !quantity) return;

    await api.post("/sweets", {
      name,
      price: Number(price),
      quantity: Number(quantity),
    });

    setName("");
    setPrice("");
    setQuantity("");
    onAdd();
  };

  return (
    <div className="card">
      <h3>Add Sweet</h3>

      <div className="form">
        <input
          placeholder="Sweet Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          placeholder="Price"
          type="number"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <input
          placeholder="Quantity"
          type="number"
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)}
        />
        <button onClick={submit}>Add</button>
      </div>
    </div>
  );
}
