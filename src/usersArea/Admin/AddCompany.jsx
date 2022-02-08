import React from 'react';
function AddCompany() {
  let _a, _b, _c;
  let _d = (0, useForm)(), register = _d.register, handleSubmit = _d.handleSubmit, errors = _d.formState.errors;
  let navigate = (0, useNavigate)();
  function send(company) {
    var _a;
    return __awaiter(this, void 0, void 0, function () {
      let id, name, address, phone, email, website, image, formData, response, added, err_1, u;
      return __generator(this, function (_b) {
        switch (_b.label) {
          case 0:
            console.log(company);
            _b.label = 1;
          case 1:
            _b.trys.push([1, 3, , 4]);
            id = company.id.toString();
            phone = company.phone.toString();
            name = company.name;
            email = company.email;
            website = company.website;
            address = company.address;
            image = ((_a = company.image) === null || _a === void 0 ? void 0 : _a.item(0));
            formData = new FormData();
            formData.append("name", name);
            formData.append("id", id);
            formData.append("website", website);
            formData.append("phone", phone);
            formData.append("image", image);
            formData.append("email", email);
            formData.append("address", address);
            return [4 /*yield*/, axios_1["default"].post(global_1["default"].urls.company, formData)];
          case 2:
            response = _b.sent();
            added = response.data;
            Store_1["default"].dispatch((0, catsAddedAction)(added)); //With Redux
            alert('company has been added');
            navigate("/company");
            return [3 /*break*/, 4];
          case 3:
            err_1 = _b.sent();
            u = err_1;
            u.message;
            return [3 /*break*/, 4];
          case 4: return [2 /*return*/];
        }
      });
    });
  }
  return (<div className="AddCompany Box">
    <h2>Add Company</h2>
    <form onSubmit={handleSubmit(send)}>
      <label>Name</label> <br />
      <input type="text" {...register("name", {
        required: true,
        minLength: 2
      })} />
      <br />

      {((_a = errors.name) === null || _a === void 0 ? void 0 : _a.type) === 'required' && <span>missing name</span>}
      {((_b = errors.name) === null || _b === void 0 ? void 0 : _b.type) === 'minLength' && <span>name is too short</span>}
      <br /> <br />
      <label>id</label> <br />
      <input type="number" step="0.01" {...register("id", {
        required: {
          value: true,
          message: 'Missing id'
        },
        min: {
          value: 0,
          message: 'id must be greater than zero'
        }
      })} />
      <br />
      <label>phone</label> <br />
      <input type="number" step="0.01" {...register("phone", {
        required: {
          value: true,
          message: 'Missing phone'
        },
        min: {
          value: 0,
          message: 'phone must be greater than zero'
        }
      })} />
      <br />
      <span>{(_c = errors.phone) === null || _c === void 0 ? void 0 : _c.message}</span>
      <br /> <br />

      <label>address</label> <br />
      <input type="text" {...register("address", { required: true })} />

      <br />
      {errors.address && <span>missing address</span>}
      <br />
      <br />
      <label>email</label> <br />
      <input type="text" {...register("email", { required: true })} />
      <br />
      {errors.email && <span>missing email</span>}
      <br />
      <br />
      <label>website</label> <br />
      <input type="text" {...register("website", { required: true })} />

      <br />
      {errors.website && <span>missing website</span>}
      <br />
      <br />
      <label>Image</label> <br />
      <input type="file" accept="companyimage/*" {...register("companyimage", { required: true })} />
      <br />
      {errors.companyimage && <span>missing companyimage</span>}
      <br /> <br />

      <button>Add</button>

    </form>
  </div>);
}
export default AddCompany;