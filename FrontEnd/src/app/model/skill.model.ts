export class skill{
    idSkill?:number;
    titleSkill:String;
    imgSkill:String;
    percentage:number;
    language:boolean;

    constructor(titleSkill:String, imgSkill:String, percentage:number, language:boolean){
        this.titleSkill = titleSkill;
        this.imgSkill = imgSkill;
        this.percentage = percentage;
        this.language = language;
    }
}