import { Component, OnInit } from '@angular/core';
import { TaskList } from '../../model/task-list';
import { TaskListService } from '../../service/task-list.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
 selector: 'app-task-list',
 standalone: true,
 templateUrl: './task-list.component.html',
 styleUrls: ['./task-list.component.css'],
 imports: [FormsModule, CommonModule],
})
export class TaskListComponent implements OnInit {
 tasks: TaskList[] = [];
 newTaskTitle = '';
 constructor(private TaskListService: TaskListService) {}
 ngOnInit(): void {
 this.tasks = this.TaskListService.getTasks();
 }
 addTask() {
  if (this.tasks.some(t => t.title === this.newTaskTitle)) return;
 if (this.newTaskTitle.trim().length === 0) return;
 const newTask: TaskList = {
 id: Date.now(),
 title: this.newTaskTitle,
 completed: false
 };
 this.tasks.push(newTask);
 this.TaskListService.saveTasks(this.tasks);
 this.newTaskTitle = '';
 }
 toggleTask(task: TaskList) {
 task.completed = !task.completed;
 this.TaskListService.saveTasks(this.tasks);
 }

 modifyTask(id: number, newTitle: string) {
  const task = this.tasks.find(t => t.id === id);
  if (task) {
    task.title = newTitle;
    this.TaskListService.saveTasks(this.tasks);
  }
}

promptModify(id: number) {
  const task = this.tasks.find(t => t.id === id);
  if (!task) return;

  const newTitle = prompt('Ingrese el nuevo título:', task.title);
  if (newTitle !== null && newTitle.trim() !== '') {
    this.modifyTask(id, newTitle);
  }
}

 deleteTask(id: number) {
 this.tasks = this.tasks.filter(t => t.id !== id);
 this.TaskListService.saveTasks(this.tasks);
 }

 get completedCount() {
  return this.tasks.filter(t => t.completed).length;
}
}
