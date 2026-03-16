"use client";

import { ChevronDown, Search, SlidersHorizontal } from "lucide-react";

export default function TableFilter() {
  return (
    <div className="w-full bg-white border border-gray-200 rounded-xl p-4 flex items-center gap-4">

      <div className="relative flex-1">
        <Search
          size={18}
          className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
        />

        <input
          type="text"
          placeholder="Search by name,email or ID"
          className="w-full border border-gray-200 rounded-lg pl-10 pr-4 py-2.5 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>

      <button className="flex items-center gap-2 border border-gray-200 rounded-lg px-4 py-2.5 text-sm text-gray-700 hover:bg-gray-50">
        All Roles
        <ChevronDown size={16} />
      </button>

      <button className="flex items-center gap-2 border border-gray-200 rounded-lg px-4 py-2.5 text-sm text-gray-700 hover:bg-gray-50">
        Status: All
        <ChevronDown size={16} />
      </button>

      <button className="border border-gray-200 rounded-lg p-2.5 hover:bg-gray-50">
        <SlidersHorizontal size={18} className="text-gray-600" />
      </button>

    </div>
  );
}