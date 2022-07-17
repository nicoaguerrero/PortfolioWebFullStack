export class person{
    id?:number;
    name:String;
    surname:String;
    degree:String;
    description:String;
    img:String;
    banner:String;

    constructor(name:String, surname:String, degree:String, description:String, img:String, banner:String){
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.description = description;
        this.img = img;
        this.banner = banner;
    }
}