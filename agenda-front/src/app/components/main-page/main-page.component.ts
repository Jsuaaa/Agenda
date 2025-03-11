import { Component } from '@angular/core';
import { CreateFormComponent } from '../../shared/forms/create-form/create-form.component';
import { AgendaTableComponent } from '../../shared/agenda/agenda-table/agenda-table.component';
import { RouterOutlet } from '@angular/router';
import { ButtonComponent } from '../../shared/button/button.component';

@Component({
  selector: 'app-main-page',
  imports: [RouterOutlet, AgendaTableComponent, CreateFormComponent, ButtonComponent],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css'
})
export class MainPageComponent {

  createFormState:boolean = false;

  constructor(){}

  notes: { name: string; description: string }[] = [];

  toggleCreateFormPopup(){
    this.createFormState = !this.createFormState;
  }

}
