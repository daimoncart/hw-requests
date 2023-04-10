import { Component } from './component';

export class Request {
    id: string;
    reasoning: string;
    status: string;
    total: number;
    createdDate: Date;
    componentBlock: Component[];
}
