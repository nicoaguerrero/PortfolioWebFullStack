export class person{
    id?:number;
    name:String;
    surname:String;
    degree:String;
    description:String;
    img:String;

    constructor(name:String, surname:String, degree:String, description:String, img:String){
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.description = description;
        this.img = img;
    }
}