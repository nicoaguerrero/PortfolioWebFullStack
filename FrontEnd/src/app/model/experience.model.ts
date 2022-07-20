export class experience{
    id_exp:number;
    titleExp:String;
    descriptionExp:String;
    dateExpStart:String;
    dateExpEnd:String;
    imgExp:String;

    constructor(id_exp:number, titleExp:String, descriptionExp:String, 
        dateExpStart:String, dateExpEnd:String, imgExp:String){
        this.id_exp = id_exp;
        this.titleExp = titleExp;
        this.descriptionExp = descriptionExp;
        this.dateExpStart = dateExpStart;
        this.dateExpEnd = dateExpEnd;
        this.imgExp = imgExp;
    }
}