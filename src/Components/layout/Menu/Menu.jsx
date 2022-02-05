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
            {/* /Admin */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">Add Coupons</Link>
            <Link to="/AddCoupons">Add Coupons</Link>
            {/* /Company */}
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/">Add Coupons</Link>
            <Link to="/AddCoupons">Add Coupons</Link>
            <Link to="/">Update Coupons</Link>
            <Link to="/UpdateCoupon">Update Coupons</Link>
            <Link to="/">delete Coupons</Link>
            <Link to="/deleteCoupon">delete Coupons</Link>
            <Link to="/">Company Coupons</Link>
            <Link to="/getCompanyCoupons">Company Coupons</Link>
            <Link to="/">Update Coupons</Link>
            <Link to="/UpdateCoupon">Update Coupons</Link>
            <Link to="/">Update Coupons</Link>
            <Link to="/UpdateCoupon">Update Coupons</Link>


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
            <Link to="/">Price</Link>
            <Link to="/getCouponsByPrice">Price</Link>
            <Link to="/">Categories</Link>
            <Link to="/getCouponsByCategory">Categories</Link>
        

            

        </div>
    );
}

export default Menu;
