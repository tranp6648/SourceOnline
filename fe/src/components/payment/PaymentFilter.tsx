import { ChevronDown, Search } from "lucide-react";

export default function PaymentFilter() {
  return (
    <div className="flex items-center justify-between gap-4">
      <div className="relative w-1/2">
        <Search
          size={16}
          className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
        />
        <input
          type="text"
          placeholder="Search by user or transaction ID..."
          className="w-full bg-gray-100 border border-gray-200 rounded-full
          pl-9 pr-4 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>
      <div className="flex items-center gap-3">
        <button className="flex items-center gap-2 bg-gray-100 border border-gray-200 rounded-full px-4 py-2 text-sm text-gray-700 hover:bg-blue-50">
          All Status
          <ChevronDown size={14} />
        </button>

        {/* Payment Method */}
        <button className="flex items-center gap-2 bg-gray-100 border border-gray-200 rounded-full px-4 py-2 text-sm text-gray-700 hover:bg-blue-50">
          Payment Method
          <ChevronDown size={14} />
        </button>
      </div>
    </div>
  );
}
