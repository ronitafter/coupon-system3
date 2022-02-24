
import CompanyModel from "../../models/CompanyModel/CompanyModel";

function CompanyDetails() {
  const [company, setCompany] = useState < CompanyModel | undefined > ();
  const fetchCompany = async () => {
    try {
      const { data: company }: { data: CompanyModel } = await jwtAxios.get(`/company/details`);
      setCompany(company);
    } catch (e) {
      console.log(e)
    }
  }

  useEffect(() => {
    fetchCompany();
  })

  return !company ? null : (
    <div className="CompanyDetailsPage">
      <h2 className='companyTitle'>{company.name} details:</h2>
      <h3 className='companyDetails'>
        ID:{company.id}<br />
        Email:{company.email}<br />
      </h3>

    </div>
  );
}

export default CompanyDetails;