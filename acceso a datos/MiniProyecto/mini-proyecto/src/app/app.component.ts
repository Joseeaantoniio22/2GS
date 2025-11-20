import { Component } from '@angular/core';
import { TaskListComponent } from './component/task-list/task-list.component';

@Component({
  selector: 'app-root',
  imports: [TaskListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mini-proyecto';
}
