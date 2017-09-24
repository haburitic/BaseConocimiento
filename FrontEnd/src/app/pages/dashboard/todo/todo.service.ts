import {Injectable} from '@angular/core';

@Injectable()
export class TodoService {

  private _todoList = [
    { text: 'Revisar e-mails' },
    { text: 'Responder e-mails' },
    { text: 'Reunión Scrum' },
    { text: 'Revisión pendientes' },
  
  ];

  getTodoList() {
    return this._todoList;
  }
}
