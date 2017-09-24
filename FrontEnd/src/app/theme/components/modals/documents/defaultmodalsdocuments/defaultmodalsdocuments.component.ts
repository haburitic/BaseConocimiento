import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'add-service-modals-documents',
  styleUrls: [('./defaultmodalsdocuments.component.scss')],
  templateUrl: './defaultmodalsdocuments.component.html'
})

export class DefaultModalsDocuments implements OnInit {

  modalHeader: string;
  modalContent: string = `Lorem ipsum dolor sit amet,
   consectetuer adipiscing elit, sed diam nonummy
   nibh euismod tincidunt ut laoreet dolore magna aliquam
   erat volutpat. Ut wisi enim ad minim veniam, quis
   nostrud exerci tation ullamcorper suscipit lobortis
   nisl ut aliquip ex ea commodo consequat.`;

  constructor(private activeModalDocuments: NgbActiveModal) {
  }

  ngOnInit() {}

  closeModal() {
    this.activeModalDocuments.close();
  }
}
