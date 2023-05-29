import { FormControl, Validators } from "@angular/forms";
import { Region } from "./region";

export class Cliente{
    id: number=0;
    nombre: string = '';
    apellido: string = '';
    email: string = '';
    createAt: string | undefined;
    foto: string | undefined;
    region: Region | undefined;
    [key: string]: any;
    constructor(){

    }
      
}