import { Injectable } from '@angular/core';
import { TaskList } from '../model/task-list';

@Injectable({
  providedIn: 'root'
})
export class TaskListService {

  private key = 'tasks';

  constructor() { }

  getTasks(): TaskList[]{
    return JSON.parse(localStorage.getItem(this.key) || '[]');
  }

  saveTasks(tasks : TaskList[]): void{
    localStorage.setItem(this.key, JSON.stringify(tasks));
  }
}
