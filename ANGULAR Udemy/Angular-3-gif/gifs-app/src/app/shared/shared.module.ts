import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { LazyImageComponent } from "./component/lazy-image/lazy-image.component";

@NgModule({
  declarations: [
LazyImageComponent
  ],
  exports: [
LazyImageComponent
  ],
  imports: [
      CommonModule
  ]
})
export class SharedModule { }
