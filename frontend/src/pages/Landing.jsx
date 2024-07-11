import { useEffect } from "react";
import companyStore from "../companyStore";
import GasProvider from "../components/GasProvider";

const Landing = () => {
  const { companies, fetchCompanies } = companyStore();
  console.log(companies);
  useEffect(() => {
    fetchCompanies();
  }, []);

  return (
    <div className="container mx-auto px-4 py-8 flex flex-wrap justify-center gap-4">
      {companies.length > 0 ? (
        companies.map((company) => (
          <GasProvider key={company.id} company={company} />
        ))
      ) : (
        <p>Loading companies...</p>
      )}
    </div>
  );
};

export default Landing;
