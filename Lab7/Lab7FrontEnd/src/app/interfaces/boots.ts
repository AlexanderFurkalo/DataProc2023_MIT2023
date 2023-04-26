import { BootsLinks } from "./RestInterfaces/Boots_Links";

export interface Boots {
    id:number;
    name:string;
    size:number;
    price:number;
    image:string;
    _links?: BootsLinks;
}
