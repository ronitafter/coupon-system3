import React, {useState } from "react";
import "./App.css";
import CompanyDetails from "../Company/CompanyDetails";

function getAllCompanies() {
   const [companies, setCompanies] = useState < CompanyDetails[] > ([]);
   const fetchCompanies = async () => {
      try {
         const { data: companies }: { data: CompanyDetails[] } = await jwtAxios.get(`/admin/allCompanies`);
         setCompanies(companies);
      } catch (e) {
         console.log(e)
      }
   }

   useEffect(() => {
      fetchCompanies();
   }, [])

   return (
      <div className="AllCompanies row">
         {companies.map(item => <CompanyTemplate key={item.id} company={item} />)}
      </div>
   );
}
export default getAllCompanies;