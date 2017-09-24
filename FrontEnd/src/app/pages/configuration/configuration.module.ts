import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './configuration.routing';
import { Configuration } from './configuration.component';
import { HttpModule } from '@angular/http';
import { ConfigurationSaga} from './components/configurationSaga/configurationSiSaga.component';
import { ViewAuthorsService} from '../../theme/services/authorsService/viewauthors.service';
import { TypeProjectsService} from '../../theme/services/typeProjectsService/typeprojects.service';
import { LabelsService} from '../../theme/services/labelsService/labels.service';
import { RoleService} from '../../theme/services/roleService/role.service';
import { PermissionService} from '../../theme/services/permissionService/permission.service';
import { ModalsConfig} from '../../theme/components/modals/config/modalsconfig.component';
import { DefaultModalsConfig} from '../../theme/components/modals/config/defaultmodalsconfig/defaultmodalsconfig.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbModalModule,
    NgbDropdownModule,
    routing,
    HttpModule,
   
   
  ],
  declarations: [
    Configuration,
    ConfigurationSaga,
    DefaultModalsConfig,
    ModalsConfig,
  ],
   entryComponents: [
    DefaultModalsConfig,
  ],
  providers: [
    ViewAuthorsService,
    TypeProjectsService,
    LabelsService,
    RoleService,
    PermissionService,
  ]
})
export class ConfigurationModule {
}

