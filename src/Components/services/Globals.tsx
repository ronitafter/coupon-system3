class Globals{
}

class DevelopmentGlobals extends Globals{
    public urls = {
        coupons: "http://localhost:8080/api/coupons/",
        images: "http://localhost:8080/api/coupons/images/"
    }
}

class ProductionGlobals extends Globals{
    public urls = {
        coupons: "http://localhost:8008/api/coupons/",
        images: "http://localhost:8080/api/coupons/images/"
    }
}

const globals = process.env.NODE_ENV === 'production' ? new ProductionGlobals : new DevelopmentGlobals;

export default globals;