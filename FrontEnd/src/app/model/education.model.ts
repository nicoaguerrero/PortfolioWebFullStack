export class education{
    idEdu:number;
    titleEdu:String;
    descriptionEdu:String;
    dateEduStart:String;
    dateEduEnd:String;
    imgEdu:String;

    constructor(idEdu:number, titleEdu:String, descriptionEdu:String, 
        dateEduStart:String, dateEduEnd:String, imgEdu:String){
        this.idEdu = idEdu;
        this.titleEdu = titleEdu;
        this.descriptionEdu = descriptionEdu;
        this.dateEduStart = dateEduStart;
        this.dateEduEnd = dateEduEnd;
        this.imgEdu = imgEdu;
    }
}