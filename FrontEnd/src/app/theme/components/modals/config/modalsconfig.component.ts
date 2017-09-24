import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DefaultModalsConfig } from './defaultmodalsconfig/defaultmodalsconfig.component';

@Component({
  selector: 'modalsconfig',
  styleUrls: ['./modalsconfig.scss'],
  templateUrl: './modalsconfig.html'
})
export class ModalsConfig {

  constructor(private modalServiceConfig: NgbModal) {}


  staticModalShowSaveConfig() {
    const activeModalConfig = this.modalServiceConfig.open(DefaultModalsConfig, {size: 'sm',
                                                              backdrop: 'static'});
    activeModalConfig.componentInstance.modalHeader = 'Acción requerida';
    activeModalConfig.componentInstance.modalContent = '¿Desea guardar?';
  }


}
