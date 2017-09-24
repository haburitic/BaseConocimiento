import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'add-service-modals-projects',
  styleUrls: [('./defaultmodalsprojects.component.scss')],
  templateUrl: './defaultmodalsprojects.component.html'
})

export class DefaultModalsProjects implements OnInit {

  modalHeader: string;
  modalContent: string = `Lorem ipsum dolor sit amet,
   consectetuer adipiscing elit, sed diam nonummy
   nibh euismod tincidunt ut laoreet dolore magna aliquam
   erat volutpat. Ut wisi enim ad minim veniam, quis
   nostrud exerci tation ullamcorper suscipit lobortis
   nisl ut aliquip ex ea commodo consequat.`;

  constructor(private activeModalProjects: NgbActiveModal) {
  }

  ngOnInit() {}

  closeModal() {
    this.activeModalProjects.close();
  }
}
