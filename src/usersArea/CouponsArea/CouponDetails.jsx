import axios from "axios";
import { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";
import CouponModel from "../../models/CouponModel/CouponModel";
import globals from "../../Components/services/Globals";

function CouponDetails(props) {

    const [state, setState] = useState({ coupon: null });
    useEffect(function () {
        try {
            const id = props.match.params.id;
            const response = await axios.get(globals.urls.coupons + id);
            setState({ coupon: response.data });
        }
        catch (err) {
            const u = err;
            alert(u.message);
        }
    }, []);
    return (
        <div className="KittenDetails Box">
            {state.coupon &&
                <>  
                    <h2>Details</h2>
                    <h3>id: {state.coupon.id}</h3>
                    <h3>companyId: {state.coupon.companyId}</h3>
                    <h3>company: {state.coupon.company}</h3>
                    <h3>title: {state.coupon.title}</h3>
                    <h3>amount: {state.coupon.amount}</h3>
                    <h3>price: {state.coupon.price}</h3>
                    <h3>description: {state.coupon.description}</h3>
                    <h3>startDate: {state.coupon.startDate}</h3>
                    <h3>endDate: {state.coupon.endDate}</h3>
                    <h3>type: {state.coupon.type}</h3>
                    <h3>image: {state.coupon.image}</h3>

                    <h3>Color: {state.coupon.color}</h3>
                    <img src={globals.urls.images + state.coupon.image} />
                    <br /><br />
                    <NavLink to="/kittens">Back</NavLink>
                </>
            }


        </div>
    );
}

export default CouponDetails;
