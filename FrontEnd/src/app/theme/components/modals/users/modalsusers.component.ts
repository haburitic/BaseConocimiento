import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DefaultModalsUsers } from './defaultmodalsusers/defaultmodalsusers.component';
import { Newuser } from '../../../../pages/users/components/newuser/newuser.component'; 

@Component({
  selector: 'modalsusers',
  styleUrls: ['./modalsusers.scss'],
  templateUrl: './modalsusers.html'
})
export class ModalsUsers {

  constructor(private modalServiceUsers: NgbModal) {}


  staticModalShowSaveUser() {
    const activeModalUsers = this.modalServiceUsers.open(DefaultModalsUsers, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalUsers.componentInstance.modalHeader = 'Acción requerida';
    activeModalUsers.componentInstance.modalContent = '¿Desea agregar el usuario?';
  }


}
