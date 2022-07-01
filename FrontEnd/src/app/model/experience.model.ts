export class experience{
    id_exp?:number;
    titleExp:String;
    descriptionExp:String;
    dateExp:String;
    imgExp:String;

    constructor(titleExp:String, descriptionExp:String, dateExp:String, imgExp:String){
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.dateExp = dateExp;
        this.imgExp = imgExp;
    }
}