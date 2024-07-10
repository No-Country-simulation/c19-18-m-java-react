const GasProvider = ({ company }) => {
  return (
    <div className="w-full md:w-1/3 px-4 py-6 bg-white rounded-lg shadow-md flex flex-col items-center">
      <h4>
        <b>Proveedor: {company.name}</b>
      </h4>
      <img
        src={company.image}
        alt="products photo"
        className="w-full rounded-lg"
      />
      <div className="mt-4 text-center">
        <p>dirección: {company.address}</p>
        <p>telefono: {company.phone}</p>
      </div>
    </div>
  );
};

export default GasProvider;
