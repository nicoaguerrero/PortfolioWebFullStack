export class proyect{
    idProyect:number;
    titlePro:String;
    descriptionPro:String;
    urlPro:String;
    imgPro:String;

    constructor(idProyect:number, titlePro:String, descriptionPro:String, urlPro:String, imgPro:String){
        this.idProyect = idProyect;
        this.titlePro = titlePro;
        this.descriptionPro = descriptionPro;
        this.urlPro = urlPro;
        this.imgPro = imgPro;
    }
}