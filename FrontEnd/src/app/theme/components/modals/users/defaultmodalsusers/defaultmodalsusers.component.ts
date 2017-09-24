import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Newuser } from '../../../../../pages/users/components/newuser/newuser.component'; 

@Component({
  selector: 'add-service-modals-users',
  styleUrls: [('./defaultmodalsusers.component.scss')],
  templateUrl: './defaultmodalsusers.component.html'
})

export class DefaultModalsUsers implements OnInit {

  modalHeader: string;
  modalContent: string = `Lorem ipsum dolor sit amet,
  consectetuer adipiscing elit, sed diam nonummy
  nibh euismod tincidunt ut laoreet dolore magna aliquam
  erat volutpat. Ut wisi enim ad minim veniam, quis
  nostrud exerci tation ullamcorper suscipit lobortis
  nisl ut aliquip ex ea commodo consequat.` ;

  constructor(private activeModalUsers: NgbActiveModal) {
  }

  ngOnInit() {}

  closeModal() {
    this.activeModalUsers.close();
  }
}
