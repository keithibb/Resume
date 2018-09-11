import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserComponent } from './components/user/user.component';
import { AdminComponent } from './components/admin/admin.component';
import { LoginComponent } from './components/login/login.component';

const router: Routes = [
    { path: '', redirectTo:'login', pathMatch:'full'},
    { path: 'login', component: LoginComponent},
    { path: 'user', component: UserComponent},
    { path: 'admin', component: AdminComponent}
];
@NgModule({
    imports: [RouterModule.forRoot(router)],
    exports: [RouterModule]
})
export class AppRoutingModule { }