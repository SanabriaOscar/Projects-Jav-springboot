import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { tap } from 'rxjs';
import { Region } from './region';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit{
 
public cliente: Cliente=new Cliente;
public regiones: Region[] | undefined;
public titulo: string="Crear cliente";
public errores: any [] | undefined;
isSubmitting = false;
  originalCliente: Cliente = new Cliente;
  clienteForm: NgForm | undefined; 


constructor( private clienteService: ClienteService, 
  private router: Router, private activatedRoute: ActivatedRoute ){

}
ngOnInit(){
  this.cargarCliente();
  this.clienteService.getRegiones().subscribe(regiones =>this.regiones=regiones);
  
  
}


cargarCliente():void{
this.activatedRoute.params.subscribe(params =>{
  let id= +params['id']
  if(id){
    this.clienteService.getCliente(id).subscribe((cliente) => this.cliente=cliente)
  }
})
}


create():void{

 /*------primera
  console.log("clicked");
console.log(this.cliente);
 this.clienteService.create(this.cliente)
 .subscribe(response =>this.router.navigate(['/clientes'])
 );*/
 /*----------code tuturial--------------*/
this.isSubmitting = true;
 this.clienteService.create(this.cliente)
 .subscribe(json =>{
  this.router.navigate(['/clientes'])
  Swal.fire('Nuevo cliente', `${json.mensaje}: ${json.cliente.nombre} `,'success')
  this.isSubmitting = false;

 },
 err =>{
  this.errores=err.error.errors as string[];
  this.isSubmitting = false;
 }
 );
}
/*
-----------------CODIGO con problema de modificacion en el editar 
-----------------manda un mensaje de crear en lugar de actualizar

update():void{
  this.isSubmitting = true;
  this.clienteService.update(this.cliente)
  .subscribe(json =>{
    this.router.navigate(['/clientes'])
    Swal.fire('Cliente actualizado', `${json.mensaje}: ${json.cliente.nombre} `,'success')
    this.isSubmitting = false;
  },
  err =>{
   this.errores=err.error.errors as string[];
   console.log(err.error.errors);
   this.isSubmitting = false;
  });
}*/
update(): void {
  if (this.clienteForm?.form.pristine) {
    Swal.fire('No se realizaron modificaciones', 'No se ha realizado ningún cambio en el cliente.', 'info');
  } else {
    this.isSubmitting = true;
    this.clienteService.update(this.cliente)
      .subscribe(
        json => {
          this.router.navigate(['/clientes']);
          Swal.fire('Cliente actualizado', `${json.mensaje}: ${json.cliente.nombre}`, 'success');
          this.isSubmitting = false;
        },
        err => {
          this.errores = err.error.errors as string[];
          console.log(err.error.errors);
          this.isSubmitting = false;
        }
      );
  }
}



compararRegion(o1:Region, o2:Region){
  if( o1===undefined && o2===undefined){
  return true;
  }
  return o1===null || o2===null || o1===undefined || o2===undefined?false:o1.id===o2.id;
}
}


