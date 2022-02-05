import { Route, Routes } from "react-router-dom";
import Home from "../Components/layout/Home/Home";
import PageNotFound from "../Components/layout/pageNotFxound/PageNotFound";
import Login from "../Components/Login/Login";
import AddCompany from "../Components/usersArea/Admin/AddCompany";
import AddCustomer from "../Components/usersArea/Admin/AddCustomer";
import Admin from "../Components/usersArea/Admin/Admin";
import GetOneCompany from "../Components/usersArea/Admin/GetOneCompany";
import GetOneCustomer from "../Components/usersArea/Admin/GetOneCustomer";
import UpdateCompany from "../Components/usersArea/Admin/UpdateCompany";
import UpdateCustomer from "../Components/usersArea/Admin/UpdateCustomer";
import CouponsList from "../Components/usersArea/CouponsArea/CouponsList";
import PurchaseCoupon from "../Components/usersArea/Customer/PurchaseCoupon";
import "./routingArea.css";

function RoutingArea() {
    return (
        <div className="routingArea">
            routingArea3
            <Routes>
                <Route path="/login" element={<Login/>} />
                <Route path="/home" element={<Home />} />
                <Route path="/admin" element={<Admin/>} />

                <Route path="/admin/GetOneCompany/:companyId" element={<GetOneCompany/>} />
                <Route path="/admin/UpdateCompany/:companyId" element={<UpdateCompany/>} />
                <Route path="/admin/getOneCustomer/:customerId" element={<GetOneCustomer/>} />

                <Route path="/admin/AddCustomer" element={<AddCustomer/>} />

                <Route path="/admin/UpdateCustomer/:customerId" element={<UpdateCustomer/>} />

                <Route path="/customer/PurchaseCoupon" element={<PurchaseCoupon/>} />
                <Route element={<PageNotFound/>} />
            </Routes>


        </div>
    );
}

export default RoutingArea;

/*
     
                <Route path="/" element={<App />} />

                
*/