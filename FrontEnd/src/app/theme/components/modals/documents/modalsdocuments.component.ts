import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DefaultModalsDocuments } from './defaultmodalsdocuments/defaultmodalsdocuments.component';

@Component({
  selector: 'modalsdocuments',
  styleUrls: ['./modalsdocuments.scss'],
  templateUrl: './modalsdocuments.html'
})
export class ModalsDocuments {

  constructor(private modalServiceDocuments: NgbModal) {}


  staticModalShowSaveDocument() {
    const activeModalDocuments = this.modalServiceDocuments.open(DefaultModalsDocuments, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalDocuments.componentInstance.modalHeader = 'Acción requerida';
    activeModalDocuments.componentInstance.modalContent = '¿Desea guardar el documento?';
  }


}
