import "./Menu.css";
import { Link } from "react-router-dom";

function Menu() {
    return (
        <div className="Menu">
            {/* /general */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">Sign Up</Link>
            <Link to="/SignUp">Sign Up</Link>
            {/* /Admin/Company */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">Add Coupons</Link>
            <Link to="/AddCoupons">Add Coupons</Link>
            <Link to="/">Add Company</Link>
            <Link to="/AddCompany">Add Company</Link>
            <Link to="/">Update Company</Link>
            <Link to="/UpdateCompany">Update Company</Link>
            <Link to="/">Delete Company</Link>
            <Link to="/deleteCompany">delete Company</Link>
            <Link to="/">Find Company</Link>
            <Link to="/getOneCompany">Find Company</Link>
            <Link to="/">Show All Companies</Link>
            <Link to="/getAllCompanies">Show All Companies</Link>
            {/* /Admin/Customer */}
            <Link to="/">Add Customer</Link>
            <Link to="/AddCustomer">Add Customer</Link>
            <Link to="/">Delete Customer</Link>
            <Link to="/deleteCustomer">Delete Customer</Link>
            <Link to="/">Show All Customers</Link>
            <Link to="/getAllCustomers">Show All Customers</Link>
            <Link to="/">Find Customer</Link>
            <Link to="/GetOneCustomer">Find Customer</Link>



            {/* /Company */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">Add Coupons</Link>
            <Link to="/AddCoupons">Add Coupons</Link>
            <Link to="/">Update Coupons</Link>
            <Link to="/UpdateCoupon">Update Coupons</Link>
            <Link to="/">Delete Coupons</Link>
            <Link to="/deleteCoupon">delete Coupons</Link>
            <Link to="/">Company Coupons</Link>
            <Link to="/getCompanyCoupons">Company Coupons</Link>
            <Link to="/">Find By Price</Link>
            <Link to="/getCompanyCouponsByPrice">Find By Price</Link>
            <Link to="/">Categories</Link>
            <Link to="/getCouponsByCategory">Categories</Link>
            <Link to="/">Delete Coupons</Link>


            {/* /Customer/User */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">My Stuff</Link>
            <Link to="/getCustomerDetails">My Stuff</Link>
            <Link to="/">Buy Coupon</Link>
            <Link to="/PurchaseCoupon">Buy Coupon</Link>
            <Link to="/">Add To Cart</Link>
            <Link to="/AddCouponToCart">Add To Cart</Link>
            <Link to="/">Get All Coupons</Link>
            <Link to="/GetAllCoupons">Your Coupons</Link>
            <Link to="/">Find By Price</Link>
            <Link to="/getCouponsByPrice">Find By Price</Link>
            <Link to="/">Categories</Link>
            <Link to="/getCouponsByCategory">Categories</Link>




        </div>
    );
}

export default Menu;
