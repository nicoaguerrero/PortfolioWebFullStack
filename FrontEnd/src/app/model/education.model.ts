export class education{
    idEdu?:number;
    titleEdu:String;
    descriptionEdu:String;
    dateEdu:String;
    imgEdu:String;

    constructor(titleEdu:String, descriptionEdu:String, dateEdu:String, imgEdu:String){
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.dateEdu = dateEdu;
        this.imgEdu = imgEdu;
    }
}