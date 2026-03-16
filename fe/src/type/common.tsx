export interface Column {
    key:string;
    title:string;
}

export interface DataTableProps {
    columns:Column[];
    data:any[];
}