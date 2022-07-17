export class experience{
    id_exp:number;
    titleExp:String;
    descriptionExp:String;
    dateExp:String;
    imgExp:String;

    constructor(id_exp:number, titleExp:String, descriptionExp:String, dateExp:String, imgExp:String){
        this.id_exp = id_exp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.dateExp = dateExp;
        this.imgExp = imgExp;
    }
}