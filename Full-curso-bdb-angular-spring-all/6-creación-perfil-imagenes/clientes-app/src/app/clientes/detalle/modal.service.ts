import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
modal: boolean=false;
  constructor() {   }
    
  abrirmodal(){
      this.modal=true;
    }
    cerrarmodal(){
      this.modal=false;
    }




}
