import { NavLink } from "react-router-dom";
import CouponModel from "../../models/CouponModel/CouponModel";
import globals from "../services/Globals";

function CouponCard(props) {
  return (
    <div className="CouponCard Box2">
      <div>
        {props.coupon.name} <br />
        id: {round(props.coupon.id)} <br />
        companyId: {round(props.coupon.companyId)} <br />
        company: {round(props.coupon.company)} <br />
        amount: {round(props.coupon.amount)} <br />
        price: {round(props.coupon.price)} <br />
        startDate: {props.coupon.startDate} <br />
        endDate: {props.coupon.endDate} <br />
        id: {round(props.coupon.id)} <br />
        type: {props.coupon.type} <br />
        image: {props.coupon.image} <br />
        description: {props.coupon.description} <br />
        {/*<span> Color: {props.coupon.color} </span><br />
  {calculateAge(new Date(props.coupon.birthday as Date) )} yo <br />*/}
      </div>
      <div>
        <NavLink to={"kittens/details/" + props.coupon.id}>
          <img src={globals.urls.coupons + '/images/' + props.coupon.image} alt={props.coupon.name} />
        </NavLink>
      </div>
    </div>
  );

  //   function round(num:number):string{
  //     return (Math.round(num * 100) / 100).toFixed(2);
  //   }
  //   function calculateAge(birthday: Date) { // birthday is a date
  //     var ageDifMs = Date.now() - birthday.getTime();
  //     var ageDate = new Date(ageDifMs); // miliseconds from epoch
  //     return Math.abs(ageDate.getUTCFullYear() - 1970);
  // }
}

export default CouponCard;