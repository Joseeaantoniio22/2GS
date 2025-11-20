import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { TaskListComponent } from './component/task-list/task-list.component';
@NgModule({
  declarations: [],
  imports: [BrowserModule, FormsModule, TaskListComponent, AppComponent],
  providers: [],
})
export class AppModule {}
