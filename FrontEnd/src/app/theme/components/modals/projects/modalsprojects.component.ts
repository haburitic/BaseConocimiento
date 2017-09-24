import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DefaultModalsProjects } from './defaultmodalsprojects/defaultmodalsprojects.component';

@Component({
  selector: 'modalsprojects',
  styleUrls: ['./modalsprojects.scss'],
  templateUrl: './modalsprojects.html'
})
export class ModalsProjects {

  constructor(private modalServiceProjects: NgbModal) {}


  staticModalShowAddSubProject() {
    const activeModalAddSubProject = this.modalServiceProjects.open(DefaultModalsProjects, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalAddSubProject.componentInstance.modalHeader = 'Acción requerida';
    activeModalAddSubProject.componentInstance.modalContent = '¿Desea guardar el documento?';
  }


  staticModalShowSaveProject() {
    const activeModalSaveProject = this.modalServiceProjects.open(DefaultModalsProjects, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalSaveProject.componentInstance.modalHeader = 'Acción requerida';
    activeModalSaveProject.componentInstance.modalContent = '¿Desea guardar el documento?';
  }

}
