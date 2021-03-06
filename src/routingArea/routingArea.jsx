import { Route, Routes } from "react-router-dom";
import Home from "../layout/Home/Home";
import PageNotFound from "../layout/pageNotFxound/PageNotFound";
import Login from "../Login/Login";
import AddCompany from "../usersArea/Admin/AddCompany";
import AddCustomer from "../usersArea/Admin/AddCustomer";
import Admin from "../usersArea/Admin/updateCompany";
import GetOneCompany from "../usersArea/Admin/GetOneCompany";
import GetOneCustomer from "../usersArea/Admin/GetOneCustomer";
//import UpdateCompany from "../usersArea/Admin/UpdateCompany";
import UpdateCustomer from "../usersArea/Admin/UpdateCustomer";
import CouponsList from "../usersArea/CouponsArea/CouponsList";
import PurchaseCoupon from "../usersArea/Customer/PurchaseCoupon";
import "./routingArea.css";

function RoutingArea() {
    return (
        <div className="routingArea">
            routingArea3
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/home" element={<Home />} />
                <Route path="/admin" element={<Admin />} />


                <Route path="/admin/AddCompany/:companyId" element={<AddCompany />} />
                <Route path="/admin/UpdateCompany/:companyId" element={<UpdateCompany />} />
                <Route path="/admin/GetOneCompany/:companyId" element={<GetOneCompany />} />
                <Route path="/admin/deleteCompany/:companyId" element={<deleteCompany />} />
                <Route path="/admin/getAllCompanies/:companyId" element={<getAllCompanies />} />

                <Route path="/admin/getOneCustomer/:customerId" element={<GetOneCustomer />} />
                <Route path="/admin/AddCustomer" element={<AddCustomer />} />
                <Route path="/admin/UpdateCustomer/:customerId" element={<UpdateCustomer />} />
                <Route path="/admin/deleteCustomer/:companyId" element={<deleteCustomer />} />
                <Route path="/admin/getAllCustomers/:companyId" element={<getAllCustomers />} />



                <Route path="/company/UpdateCoupon" element={<UpdateCoupon />} />
                <Route path="/company/AddCoupons" element={<AddCoupons />} />
                <Route path="/company/deleteCoupon" element={<deleteCoupon />} />
                <Route path="/company/getCompanyCoupons" element={<getCompanyCoupons />} />
                <Route path="/company/AddCoupons" element={<PurchaseCoupon />} />
                <Route path="/company/getCouponsByCategory" element={<getCouponsByCategory />} />
                <Route path="/company/getCompanyCouponsByPrice" element={<getCompanyCouponsByPrice />} />

                <Route path="/customer/PurchaseCoupon" element={<PurchaseCoupon />} />
                <Route path="/customer/getCustomerDetails" element={<getCustomerDetails />} />
                <Route path="/customer/GetAllCoupons" element={<GetAllCoupons />} />
                <Route path="/customer/getCouponsByPrice" element={<getCouponsByPrice />} />
                <Route path="/customer/getCouponsByCategory" element={<getCouponsByCategory />} />

                <Route element={<PageNotFound />} />






            </Routes>


        </div>
    );
}

export default RoutingArea;

/*
         <Route path="/admin/UpdateCompany/:companyId" element={<UpdateCompany/>} />
                <Route path="/" element={<App />} />

                
*/