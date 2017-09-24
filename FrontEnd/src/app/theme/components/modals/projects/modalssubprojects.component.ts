import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DefaultModalsProjects } from './defaultmodalsprojects/defaultmodalsprojects.component';

@Component({
  selector: 'modalssubprojects',
  styleUrls: ['./modalsprojects.scss'],
  templateUrl: './modalssubprojects.html'
})
export class ModalsSubProjects {

  constructor(private modalServiceProjects: NgbModal) {}

  staticModalShowAddDocument() {
    const activeModalAddDocument = this.modalServiceProjects.open(DefaultModalsProjects, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalAddDocument.componentInstance.modalHeader = 'Acción requerida';
    activeModalAddDocument.componentInstance.modalContent = '¿Desea guardar el documento?';
  }

  staticModalShowSaveProject() {
    const activeModalSaveProject = this.modalServiceProjects.open(DefaultModalsProjects, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalSaveProject.componentInstance.modalHeader = 'Acción requerida';
    activeModalSaveProject.componentInstance.modalContent = '¿Desea guardar el documento?';
  }

}
