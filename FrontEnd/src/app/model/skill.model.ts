export class skill{
    idSkill:number;
    titleSkill:String;
    imgSkill:String;
    percentage:number;
    language:boolean;

    constructor(idSkill:number, titleSkill:String, imgSkill:String, percentage:number, language:boolean){
        this.idSkill = idSkill;
        this.titleSkill = titleSkill;
        this.imgSkill = imgSkill;
        this.percentage = percentage;
        this.language = language;
    }
}